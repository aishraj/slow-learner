import pymongo
import sys

# establish a connection to the database
connection = pymongo.Connection("mongodb://localhost", safe=True)

# get a handle to the school database
db=connection.students
scores = db.grades


def find():

    print "find, reporting for duty"
    query = {"type": "homework"}
    '''selector = {'student_id': 1 , '_id': 0}'''

    try:
        cursor = scores.find(query)
        cursor = cursor.sort([('student_id',pymongo.ASCENDING),('score',pymongo.ASCENDING)])

    except:
        print "Unexpected error:", sys.exc_info()[0]

    last_id = -1
    for doc in cursor:
        if doc[u'student_id'] != last_id :
            scores.remove(doc)
            last_id = doc[u'student_id']



def find_one():

    print "find one, reporting for duty"
    query = {'student_id':10}

    try:
        doc = scores.find_one(query)

    except:
        print "Unexpected error:", sys.exc_info()[0]


    print doc


find()

