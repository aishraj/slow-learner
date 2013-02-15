import pymongo

connection = pymongo.Connection("mongodb://localhost",safe=True)
db=connection.school
students=db.students

def find_lowest_hw(scores):
    lowest = None
    lowest_score = 101
    for item in scores:
        if (item['type'] == "homework") and (item['score'] < lowest_score):
            lowest = item
            lowest_score = lowest['score']

    return lowest

def remove_lowest():
    cursor = students.find()
    for student in cursor:
        print "Current Student is" , student['_id']
        scores = student["scores"]
        lowest = find_lowest_hw(scores)
        if (lowest is not None):
            print "Removing hw of grade", lowest["score"], "from student" , student["_id"]
            scores.remove(lowest)
            try:
                students.update({'_id':student['_id']},{'$set' :{'scores':scores}})
            except:
                print "Error :", sys.exc_info()[0]
                raise
            else:
                print "Could not find a homework score to drop"

remove_lowest()
