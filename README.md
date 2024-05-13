# CS136-Final-Project
## Hashed Array Tree --- A List Data Type 
A Hashed Array Tree (HAT) is a dynamic array data structure in which there is a parent array and child arrays that are all the same size. The size of each array is a power of two, and when the array is full, the size will double to be able to accomodate more elements. The creator of this data structure made it with the intentions of cutting down on runtime when resizing the array, especially in the copying of elements into the resized array. 

In our implementation of a HAT, we did so with an array of arrays. To ensure that the append operation would have a runtime of O(1), we kept track of the parent and child positions of elements, so that we could increment them and add more elements without iterating through the entire array (like what would be done in something like an ArrayList or a Linked List). When printed, our HAT looks like a regular array. 


Here's an example of a Hashed Array Tree with 16 elements and 4 leaves in the parent array:

<p align="center">
	<img src="figs/HashedArrayTree16.png" width="250" height="250" />
</p>


Our implementation of a Hashed Array Tree will will be used for an application that uses real-life movie data to store information including movie titles, genre, release year, and director. Our data is stored in `array/movies.csv`, with a toy data set being stored in `array/toyMovies.csv`, used for testing purposes. 

## Challenges 
A challenge we have had is staying within the constraints set by a Hashed Array Tree, like each array being a power-of-two size, and making sure that each array had the same size. We also struggled with our `.add` operation as the elements had to be pushed back to still be in the same order after a resize. 

Another challenge we have encountered is the time-space tradeoff of using a dynamic array which has the capacity to waste an enormous amount of space. For example, if our parent array is n elements big, then each leaf is also n elements big, and if we only use 3 elements of the child array, then we have a waste of n-3 elements. The bigger the dataset, the more wastage we have.

We decided that instead of inserting every movie in a dataset, we would instead sort by a user-specified query and have a set number of movies inserted into the Hashed Array Tree.

## Data
Our data is from scraped IMDb data, which includes pertinent information (i.e., the movie's name, rating, genre, release year, average score, director and star) and other information that we will not be using in our application like budget and earnings. 

## Application
HATboxd, the name of our application, will ask the user to filter by certain pieces of information about a film, which are included in our encapsulation of a MovieInfo object that takes in the name, rating, genre, release year, average score, director and star. That filtered information will then be sorted based onthe average score, and our HAT will recommend to the user the highest rated films with that particular filter. 

Our application opens with the following: 
````
Welcome to HATboxd :D
- Choose a query to filter & sort by (type & enter the number):
-- 1) Rating   2) Genre   3) Year   4) Director   5) Star
````
It will then return a list with the top movies with the particular rating. The user will also have an option to quit, and will exit the application. 

For example, the user could type & enter `4`, and will be prompted to input a particular director. If the user were to type `Christopher Nolan`, the following prints in the terminal: 
````
Your HATboxd:
[The Dark Knight (Christopher Nolan, 9.0), Inception (Christopher Nolan, 8.8), 
Interstellar (Christopher Nolan, 8.6), The Prestige (Christopher Nolan, 8.5), 
Memento (Christopher Nolan, 8.4), ]
````

We were inspired by Letterboxd, a website in which users can rate and review films they watch. 

## Compiling and Executing 
Before compiling, make sure to be in the same directory as the `README.md`. 

Then, make a bin directory to store the .class files. 

````
mkdir bin 
````

Run the following command to compile: 

````
javac -d bin array/*.java
````

To execute the HATboxd application, run the following command: 

````
java -cp bin array/Movie
````
