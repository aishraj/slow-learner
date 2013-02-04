import bottle

@bottle.route('/')
def home_page():
    print 'home'

@bottle.route('/test')
def test_page():
    print 'test page'

bottle.debug(True)
bottle.run(host = 'localhost', port = 8080)
