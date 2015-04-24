import groovy.json.JsonSlurper

def slurper = new JsonSlurper()
def jsonPayload = slurper.parseText(payload)
def fromUser = jsonPayload?.user?.screen_name
def text = jsonPayload?.text
def createdAt = jsonPayload?.created_at
def languageCode = jsonPayload?.lang
def retweetCount = jsonPayload?.retweet_count
def retweet = jsonPayload?.retweeted
def hashTags = jsonPayload?.entities?.hashtags

def builder = new groovy.json.JsonBuilder()
builder id: jsonPayload.id_str, fromUser: fromUser, createdAt: createdAt, text: text, languageCode: languageCode, retweetCount: retweetCount, retweet: retweet



//    result = result + jsonPayload.id_str + '\t' + fromUser + '\t' + createdAt + '\t' + tag.text.replace('\r', ' ').replace('\n', ' ').replace('\t', ' ') + '\t' + languageCode + '\t' + retweetCount + '\t' + retweet

return builder.toString()
