# Doctor_Patient APIs
This project provides backend APIs for a doctor-patient portal. The APIs allow doctors to register their patients and manage their 
information, as well as suggest doctors based on patient symptoms and location.

## Technologies Used
* Java
* Spring Boot
* Hibernate
* MySQL
* Swagger
## Entities : 
![dptbl](https://user-images.githubusercontent.com/117101699/234497220-255874bc-e976-4338-a47c-311d1ca0b5d5.png)

## API Endpoints : 
* Doctor APIs
  * POST api/doctor/add: add a new doctor to the platform
  * GET api/doctor/get-all: get a list of all doctors on the platform or a doctor with id
* Patient APIs
  * POST /add-patient: add a new patient to the platform
  * DELETE /remove-patient/{patientId}: remove a patient from the platform
  * GET /getall-patient: get a list of all patients on the platform
* Suggest Doctor API
  * GET /suggest/{patientId}: suggest a doctor based on patient symptoms and location
## Running the Application
* Clone this repository to your local machine
* Install MySQL and create a new database
* Update the application.properties file with your database credentials
* Run the project 
* Navigate to http://localhost:8080/swagger-ui.html to view the Swagger UI and test the APIs
## Validations
The following validations are implemented for the patient and doctor entities:

* Name (should be not empty)
* City (should be not empty)
* Email (should be a valid email address)
* Phone number (should be at least 10 numbers)
## Edge Cases
The following edge cases are handled by the suggest doctor API:

* If there isn't any doctor on that location (i.e. outside Delhi, Noida, Faridabad), the response is "We are still waiting to expand to your location"
* If there isn't any doctor for that symptom on that location, the response is "There isn't any doctor present at your location for your symptom"
