
Add-PSSnapin "VMware.VimAutomation.Core" | Out-Null
Connect-VIServer 10.68.96.28 -User root -Password immersion


$dns = "10.103.42.51"
$mastertemplate = "C6Master32_2_HDP"
$slavetemplate = "C6Slave32_2"
$startip = 245
$endip = 254
$domain = "fe.gopivotal.com"
$hostprefix = "is1-"
$ipprefix = "10.68.104."
$gateway = "$($ipprefix)1"
$subnetmask = "255.255.255.0"
$Networkname = "vm_network"
$vmhost = "10.68.96.16"

$hostfile = "127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4\r\n"

foreach($i in $startip..$endip){

#Setting VM name and IP based on position in the loop
$vmname = $hostprefix + $i
$ipaddress = "$($ipprefix)$($i)"
$hostfile = $hostfile + $ipaddress + " " + $vmname + "." + $domain + " " + $vmname + "\r\n"

#Setting up $custspec variable
$custSpec = New-OSCustomizationSpec -Type NonPersistent -OSType Linux -Domain $domain


#Adding network information to custspec
$custSpec | Get-OSCustomizationNicMapping | Set-OSCustomizationNicMapping -IpMode UseStaticIP -IpAddress $ipaddress -SubnetMask $subnetmask -DefaultGateway $gateway
if ($i -eq $startip) {
New-VM -Name $vmname -Template $mastertemplate -datastore datastore2 -OSCustomizationSpec $custSpec -vmhost $vmhost
}
else
 {
 if ($i % 2 -gt 0) {
 New-VM -Name $vmname -Template $slavetemplate -datastore datastore2 -OSCustomizationSpec $custSpec -vmhost $vmhost
 }
 else
 {
 New-VM -Name $vmname -Template $slavetemplate -datastore datastore3 -OSCustomizationSpec $custSpec -vmhost $vmhost
 }
}
Start-VM -VM $vmname


}

$vmname = "$($hostprefix)$($startip+1)"
write-host “Waiting for VM Tools to Start”
2
do {
3
$toolsStatus = (Get-VM $vmname | Get-View).Guest.ToolsStatus
4
write-host $toolsStatus
5
sleep 3
6
} until ( $toolsStatus -eq ‘toolsOk’ )
sleep 60
foreach($i in $startip..$endip){
$vmname = "$($hostprefix)$($i)"

$dnsscript = "echo 'nameserver " + $dns + "' > /etc/resolv.conf"
$hostscript = "echo -e '"+ $hostfile + "' > /etc/hosts"

## Invoke-VMScript -VM $vmname -ScriptText "echo 'nameserver 10.68.0.10'> /etc/resolv.conf" -GuestUser "root" -GuestPassword "password"
Invoke-VMScript -VM $vmname -ScriptText $dnsscript -GuestUser "root" -GuestPassword "password"
Invoke-VMScript -VM $vmname -ScriptText $hostscript -GuestUser "root" -GuestPassword "password"


}