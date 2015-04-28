import groovy.json.JsonSlurper

def slurper = new JsonSlurper()
def jsonPayload = slurper.parseText(payload)
def var_id = jsonPayload?.id
def var_fromUser = jsonPayload?.from_user
def var_text = jsonPayload?.text.replaceAll(/,/,' ').replaceAll(/'/,'').replaceAll(/"/,'')
def var_createdAt = jsonPayload?.created_at
def var_languageCode = jsonPayload?.language_code
def var_retweetCount = jsonPayload?.retweet_count
def var_retweet = jsonPayload?.retweeted
def hashTags = jsonPayload?.entities?.hashtags


var_retweetCount = var_retweetCount - 50000         
def csv = var_id + ',' + var_fromUser + ',' + var_createdAt + ',"' + var_text + '",' + var_languageCode + ',' + var_retweetCount

return csv
