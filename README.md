# Project Name
Hotel Search API

## Table of Contents

- [Prerequisites](#prerequisites)
- [Building the Project](#building-and-running-the-project)
- [Project Structure](#project-structure)
- [Testing](#testing)

## Prerequisites 

IntelliJ IDE installed, with gradle plugin, and Amazon Corretto 11. Postman desktop version.

## Building and running the project
Open the project using IntelliJ and automatic build should trigger. Assure that your project settings
are correct, opening Project Structure -> Project, and assuring that the SDK is set to Amazon Corretto
11.0.24 or another compatible version.

Navigate to src/main/kotlin/com.expedia/Applicaton.kt and click the play button to the left of Application
and select 'Run ApplicationKt.main()'. The project will start and when it's ready, you should see:


Responding at http://127.0.0.1:8080 in the terminal. 

Once the project is started, a search request can be made to the server using postman desktop version with the following
params:

POST -> http://127.0.0.1:8080/search
BODY -> Select raw, JSON and submit request:

{"location":"Paris",  <br/>
"checkinDate":"2024-12-01",  <br/>
"checkoutDate":"2024-12-14",  <br/>
"priceRange":[100,200]}  <br/>

Results:
![Response](images/searchResponse.PNG)


## Project structure
For the purpose of this assessment, an in-memory mock data source is used for Hotel Data.

The project is organized to have an interface that will define the contracts for any services that perform searches.
Search logic is contained in domain/Hotel Search Service/Hotel Fitler, and the models package contains the relevant data models
for the search service, as well as the data models for requests and responses to and from the service. 

The project uses the KTOR framework to create the API server, and the routes are contained in routes folder.

Currently, this project takes a user search input and filters hotels by the input location, returning a list
of hotels in the search location, ordered by average review (starting with the highest reviews).


src/ <br/>
└── main/ <br/>
└── kotlin/ <br/>
└── com/expedia/ <br/>
├── domain/ <br/>
│   ├── HotelFilter <br/>
│   └── HotelSearchService.kt < <br/>
|    └── MockHotelDataSource.kt <br/>
├── interfaces/ <br/>
│   └── HotelSearchInterface.kt <br/>
├── models/ <br/>
│   ├── Hotel.kt <br/>
│   ├── HotelSearchRequest.kt <br/>
│   ├── HotelSearchResponse.kt <br/>
│   └── Location.kt <br/>
│   └── Review.kt <br/>
├── plugins/ <br/>
│   ├── Routing.kt <br/>
│   └── Serialization.kt <br/>
├── routes/ <br/>
│   ├── HotelSearchRoutes.kt <br/>
│   └── Application.kt <br/>


## Testing
Basic testing has been added for now, assuring that the API responds correctly when receiving an adequate
search request. The hotel filter functionality has also been tested to assure that hotels are sorted and 
returned by review rating, starting with the highest rated. Future improvements will include adding error handling
and testing for edge cases (ie. malformed search request, search requests that return no results, etc.)