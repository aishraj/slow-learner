"""

This is the source code of a bare bone Twitter Bot that uses the Twitter Python Library.
It finds users who tweeted about "Dell Social Innovation Challenge", favourites their tweets,
follows them and then sends them a tweet with a link to Project Code - an initiative to teach kids
programming at an early age.

"""

import urllib
import simplejson
import twitter

consumer_key = 'YOUR_KEY_HERE'
consumer_secret = 'YOUR SECRET HERE'
access_token_key = 'YOUR TOKEN HERE'
access_token_secret = 'YOUR TOKEN SECRET HERE'

def searchTweets(query):
    search = urllib.urlopen('http://search.twitter.com/search.json?q='+query)
    dict = simplejson.loads(search.read())
    return dict

api = twitter.Api(consumer_key = consumer_key, consumer_secret = consumer_secret, access_token_key = access_token_key, access_token_secret = access_token_secret)
tweets = searchTweets("dell+social+innovation+challenge&rpp=100&result_type=recent")
msg = 'Hello there! Saw your tweet about DSIC. Will be thankful if you could vote for Code at http://goo.gl/MhMmJ'

for i in range(len(tweets["results"])):
    tweeter = tweets["results"][i]["from_user"]
    status = twitter.Api.GetStatus(api, tweets["results"][i]["id"])
    api.CreateFavorite(status)
    api.CreateFriendship(tweeter)
    """TODO: Need to add a uniquie string perhaps an MD5 hash to each tweet to bypass duplicate  tweet detection"""
    api.PostUpdate('@' + tweeter + ' ' + msg)

