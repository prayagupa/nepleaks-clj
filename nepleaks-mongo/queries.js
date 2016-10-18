var db = new Mongo().getDB("zomato")

let documents = db.restaurants.find({})

let projectedDocuments = db.restaurants.find({}, {"restaurant_id" : 1, "name" : 1, "borough" : 1, "cuisine" : 1})

let excludeId = db.restaurants.find({}, {"restaurant_id" : 1, "name" : 1, "borough" : 1, "cuisine" : 1, "_id" : 0})

let exclude_Id = db.restaurants.find({}, {"restaurant_id" : 1, "name" : 1, "borough" : 1, "zipcode" : 1, "_id" : 0})

//filter

let documentsInBronx = db.restaurants.find({"borough" : "Bronx"}, {})

let fiveDocumentsInBronx = db.restaurants.find({"borough" : "Bronx"}, {}).limit(5)

let nextFiveDocumentsInBronx = db.restaurants.find({"borough" : "Bronx"}, {}).skip(5).limit(5)

let latitudeLessThan = db.restaurants.find({"address.coord.0" : { $lt : -95.754168}}, {})

let longtitude = db.restaurants.find({"address.coord.1" : { $lt : 52, $gt : 42}, {})

let notAmericanCuisine = db.restaurants.find({"cuisine" : {$ne : "American"}, {"grades.score" : {$all : [[70]]}}})

db.restaurants.find({"name" : {$regex :  "Wil.*"}}, {"name" : 1, "borough" : 1})

db.restaurants.find({"name" : {$regex :  ".*ces"}}, {"name" : 1, "borough" : 1, "restaurant_id" : 1})

db.restaurants.find({"name" : {$regex :  ".*ces.*"}}, {"name" : 1, "borough" : 1, "restaurant_id" : 1})

db.restaurants.find({"borough" :"Bronx" , "cuisine" : {$in : ["American", "Chinese"]}})

db.restaurants.find({ "borough" : {$in : ["Staten Island", "Queens", "Bronxor Brooklyn"]}})

db.restaurants.find({ "borough" : {$nin : ["Staten Island", "Queens", "Bronxor Brooklyn"]}})

db.restaurants.find({"grades.score": {$lte : 10}})

//sort
db.restaurants.find({}, {}).sort({"name" : 1})

db.restaurants.find({}, {}).sort({"name" : -1})

db.restaurants.find({}, {}).sort({"cuisine" : 1, "borough" : -1}).limit(10).pretty()

db.restaurants.find({"name" : {$regex :  "Mad.*"}}, {"name" : 1, "borough" : 1})
