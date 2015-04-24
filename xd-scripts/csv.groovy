import groovy.json.JsonSlurper

def slurper = new JsonSlurper()
def jsonPayload = slurper.parseText(payload)
def var_id = jsonPayload?.id_str
def var_fromUser = jsonPayload?.user?.screen_name
def var_text = jsonPayload?.text.replaceAll(/,/,' ').replaceAll(/'/,'').replaceAll(/"/,'')
def var_createdAt = jsonPayload?.created_at
def var_languageCode = jsonPayload?.lang
def var_retweetCount = jsonPayload?.retweet_count
def var_retweet = jsonPayload?.retweeted
def hashTags = jsonPayload?.entities?.hashtags


def var_rand_id = java.util.UUID.randomUUID().toString()
         
def csv = var_rand_id + ',' + var_fromUser + ',' + var_createdAt + ',"' + var_text + '",' + var_languageCode + ',' + var_retweetCount + ',' + var_retweet

return csv
