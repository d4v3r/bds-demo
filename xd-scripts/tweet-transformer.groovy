import groovy.json.JsonSlurper

def slurper = new JsonSlurper()
def jsonPayload = slurper.parseText(payload)
def var_id = jsonPayload?.id
def var_fromUser = jsonPayload?.from_user
def var_text = jsonPayload?.text
def var_createdAt = jsonPayload?.created_at
def var_languageCode = jsonPayload?.language_code
def var_retweetCount = jsonPayload?.retweet_count


com.pivotal.twitter.Tweet tweet = new com.pivotal.twitter.Tweet()
tweet.setId(var_id)
tweet.setFrom_user(var_fromUser)
tweet.setCreated_at(var_createdAt)
tweet.setText(var_text)
tweet.setLanguage_code(var_languageCode)
tweet.setRetweet_count(var_retweetCount)



return tweet
