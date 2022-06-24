# LedControlApp

## What is this repository for? ##

* Integration between a simple companion app with a linux embedded system made of an arduino and raspberry linked via serial cable
* Establish command submitting to field via REST Api   
* Subscribe to field events via WebSocket
* v1.0.0

## Dependencies list and usage ##

* *androidx.activity:activity-compose*: UI building with Android Compose new declarative paradigm
* *com.google.dagger:hilt-android*: dependency injection library
* *androidx.hilt:hilt-navigation-compose*: navigation component integrated with hild and compose
* *androidx.room:room-* : store data onboard with key-value structure
* *com.squareup.retrofit2:retrofit*: perform REST calls
* *com.squareup.retrofit2:converter-gson*: library to perform object mapping
* *org.jetbrains.kotlinx:kotlinx-coroutines-* : handle long tasks in background threads
* *io.coil-kt:coil-compose*: asnycronous loading of images from web urls
* *androidx.test.ext:junit*: unit test TODO
* *androidx.test.espresso:espresso-core*: TODO

## Project structure ##

```
app   
│
└─── data
│    │
│    └─── datasource
│    │
│    └─── di
│    │
│    └─── dto
│    │
│    └─── network
│    │
│    └─── entities
│         
└─── domain.usecases
│    │
│    └─── utils
│
└─── presentation
│    │
│    └─── components
│    │
│    └─── navigation
│    │
│    └─── theme
│    │
│    └─── ui.screens
```


## App screenshots and high level behaviour ##

After launch the application opens two communication channels with the field: Web API client to send commands, and WebSocket channel to receive events.
Immediately adjusts lamp status basing on current led status on the field.

The app can send commands on/off to the lead and is able to react in case the led's status changes directly on the field.

The app has also a MockDatasource useful to simulate it's behaviour, that is activated by default.

<p float="left">
  <img width="271" alt="Screenshot 2022-06-14 at 15 31 40" src="https://user-images.githubusercontent.com/107438397/175665348-388890d9-810f-4082-a841-77e113dd0440.gif">
  
  <img width="271" alt="Screenshot 2022-06-14 at 15 31 15" src="https://user-images.githubusercontent.com/107438397/175660216-2b11c12c-4638-4564-bb97-bf3afc4fb9dd.png">
  
  <img width="271" alt="Screenshot 2022-06-14 at 15 31 40" src="https://user-images.githubusercontent.com/107438397/175660221-81949f32-4a4c-4654-a483-e939fcd98c81.png">
</p>



