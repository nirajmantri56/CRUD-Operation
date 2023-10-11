In this I have done basic operations of adding an item and get item by an id without using any database storage. Here, I am using an ArrayList to store the data.

1.If you want add the data then you have to send a POST request from Postman and 
give the url as 'https://crud-operation-production-1d01.up.railway.app/items/add' 
and input body in the JSON format as - 

{
    "name": "Name of Item",
    "description": "Description of an item"
}

2.For getting an item by id, send the GET request as -  'https://crud-operation-production-1d01.up.railway.app/items/id' 
(ex. '/items/1' here 1 is id number)

Validation is also enabled. 
