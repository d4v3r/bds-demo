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
	if (hashTags == null || hashTags.size() == 0) {
  		builder hashtags: []
	} else {
		builder.hashtags{
	
  		hashTags.each { tag ->
  		hashtag(
  		 id: java.util.UUID.randomUUID().toString(),
  		 tweetId: jsonPayload.id_str,
  		 text: tag.text,
  		 languageCode: languageCode
  		)
  		}
  		}
    }






return builder.toString()
