import groovy.json.JsonSlurper

def slurper = new JsonSlurper()
def jsonPayload = slurper.parseText(payload)
def var_id = jsonPayload?.id_str
def var_fromUser = jsonPayload?.user?.screen_name
def var_text = jsonPayload?.text
def var_createdAt = jsonPayload?.created_at
def var_languageCode = jsonPayload?.lang
def var_retweetCount = jsonPayload?.retweet_count
def var_retweet = jsonPayload?.retweeted
def hashTags = jsonPayload?.entities?.hashtags

def builder = new groovy.json.JsonBuilder()
def var_rand_id = java.util.UUID.randomUUID().toString()
	builder {
	  id var_rand_id
          from_user var_fromUser
          created_at var_createdAt
          text var_text
          language_code var_languageCode
          retweet_count var_retweetCount
	}




return builder.toString()
