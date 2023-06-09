# Proyect of the second semester Fundamentals of programming (Course <2022>/<23>)
Autor/a: <Miguel Prado Jiménez> uvus:<NKY1852>

The dataset I am going to work with is about mental health, so we will consider each row as a patient, with its own information given by the different columns.

## Proyect folders structure

* **/src**: Where the main code can be found.
    * **\<types>**: Package which contains contains the types of the proyect and the class where we will be testing our work.
    * **\<utils>**: This package contains the utility classes
    * **\<common>**: Package which contains the auxiliary types (as the enums or auxiliary classes)


* **/data**: It contains the dataset we are using in the proyect
    * **\<mentalHealth.csv\>**: CSV archive which contains the data of the different patients

## Estructure of the *dataset*

The dataset I am going to work with can be found and downloaded in the next link (http://kaggle.com/lucaskg/mentalhealthsurvey). The original dataset has 28 columns of which we will use 11 (the ones more suitable for our purposes, as they are the ones which we will work with, in addition to one added manually, "names" with some randomly generated ones).My project will count with 1260 rows, given by the dataset itself.

My data set contains \<11\>  different columns which give information about:

* **\<Name>**: type \<String\>, represents the name of the patient
* **\<Patient>**: type  \<int\>, represents number of the patient, increasing in order as it does the time when they got checked
* **\<Timestamp>**: type \<LocalDateTime\>, represents the time when they got checked
* **\<Age>**: type \<int\>, the age of the patient
* **\<Gender>**: type \<int\>, if it is a 1, then the patient is a woman. -1 is a man 
* **\<Country>**: type \<String\>, their country of birth
* **\<State>**: type \<String\>, if they're from the USA, then it will show the state their from, otherwise, it will be empty
* **\<family_history>**: type \<int\>, 1 represents they have familiar background with mental issues, -1 otherwise
* **\<treatment>**: type \<int\>, 1 represents if they're being medicated, -1 if they aren't.
* **\<work_interfere>**: type \<Double\>, greater if their work interferes in their personal live.
* **\<remote_work>**: type \<String\>, says whether they work from home or they don't

## Implemented types

The types that have been implemented in the proyect are the following

### Base type - Patient

Represents the data about a patient

**\<Properties>**

name, type <String>, searchable and modifiable. The name of the patient.<br>

nPatient, type <int>, searchable and modifiable. The number of the patient (simbolizes order of treatment).<br>

date, type <LocalDateTime>, searchable. When did the patient got the examination.
age, type <int>, searchable. The age of the patient.<br>

gender, type<Gender> searchable and modifiable. Indicates the gender of the patient. Can take the values MAN,WOMAN.<br>

country, type<String> searchable and modifiable. Their country of birth.<br>

state, type<String> searchable. If they're from the USA, it shows what state they're from.<br>

treatment, type<Treatment> searchable and modifiable. Shows with two boolean values if they have family record, and if they are taking some kind of treatment.<br>

workInterfere, type<Double> searchable and modifiable. As greater the number, greater the implication its work has with their personal live.<br>

employ, type<Employ>, searchable. Indicates what kind of work they are in. Can take the values UNKNOWN,UNEMPLOYED,WORKER,SELFEMPLOYED.<br>

remoteW, type<boolean>, searchable and modifiable. True if they work from home, false otherwise.<br>

comentaries, type<List<String>> searchable and modifiable. Some comentaries about the characteristics of the patient.</p>

**\<Constructors>**

C1: Has a parameter for each basic property of the type.<br>
C2: Creates a type *Patient* from the following parameters *String name, int nPatient, int age, Treatment treatment*.</p>

**\<Restrictions>**

R1: the name of the patient cannot be empty.<br>
R2: the age of the patient cannot be less than 5 years.<br>
R3: the date of the examination must be after year 2014 (included).</p>

***Equality criterium**: Two patients are equal if all their basic properties are equal.

***Order criterium**: First by name, then by patient number.

***Other operations**:

- _: Descripción del método 1.

### Auxiliary type - Treatment

One of the basic properties in Patient

**\<Properties>**

fRecord, type<boolean>, searchable and modifiable. True if he/she has family record , false if he/she doesn't<br>

treatment, type<boolean>, searchable and modifiable.. True if he/she takes medication, false if he/she doesn't</p>

**\<Constructors>**

C1: Has a parameter for each basic property of the type.<br>
C2: Doesn't take parameters.

***Equality criterium**: Two treatments are equal if all their basic properties are equal.

***Other operations**:

-*boolean isUrgent*. Which takes no atributes, and depending on the values of the basic properties of Treatment, it will return true if the patient condition is critical, false otherwise

#### Auxiliary types

- Gender, enumerated. Takes the values MAN,WOMAN.
- Employ, enumerated. Takes the values UNKNOWN,UNEMPLOYED,WORKER,SELFEMPLOYED.
- Treatment, mentioned before



### Factory - FactoryPatient
Class which contains the methods necessary for creating objects of type Patient and Patients

-*Patient parsePatient(String line)*: It creates a Patient from the information given in the string.<br>
-*Patients readPatients(String route)*: It creates an object of type Patients, with the information available in the csv file, whose route is given as a parameter.</p>

### Container type - Patients
Container class of the objects of type Patient

**\<Properties>**

patients, of type <Set<Patient>>, consultable. Set of patients from the clinic</p>

**\<Constructors>**

C1: Doesn't take parameters.<br>
C2: Has a parameter of type Collection<Patient>. It creates an object of type Patients with the information in the collection. <br>
C3: Constructor with a parameter of type Stream<Patient>. It creates the object with the Patients given in the stream.</p>

***Equality criterium**: Two patients are equal if all their basic properties are equal.


***Other operations**:

-*Integer getNumberPatients*: It returns the number of patients inside the Set.<br>
-*void addPatient(Patient p)*: It adds a Patient to the object.<br>
-*void addPatients(Colletion<Patient> c)*: Adds a collection of Patients to the object.<br>
-*void deletePatient(Patient p)*: Removes the patient given as parameter if there is one to be found which fulfills the equality criterium.<br>
-*Patient displayPatient(Integer nPatient)*: It shows in the terminal the patient whose number is the one given as parameter.<br>
-*Boolean existsPatient(Patient patient)*: Returns true or false depending on whether that patient is in the object or not.<br>
-*Integer countPatientsGender(Gender g)*: Returns the number of patients of the given gender.<br>
-*Set<Patient> filterYoungerThan(Integer age)*: It returns a set with the patients which are younger than the given age.<br>
-*Map<String, Set Patient> patientsByCountry*: Returns a diccionary whose keys are the countries from which the patients are from, and the values are these patients whith that nationality.<br>
-*Map<String, Integer> countPatientsState*: Creates a diccionary whose keys are the states from which the patients are from (given that there are so many americans) and the values the number of patients from that state.</p>
****Third delivery****</p>
-*Boolean extistsPatient2(Patient p)*: Same functionality as the first, but implemented with streams instead of loops<br>
-*Integer countPatientsGender2(Gender g)* : Same functionality as the first, but implemented with streams instead of loops<br>
-*Set<Patient> filterYoungerThan2(Integer age)*: Same functionality as the first, but implemented with streams instead of loops<br>
-*Patient getOldestPatient(Gender g)*: It returns the oldest patient according to age, and to the gender introduced as input<br>
-*List<Patient> getLatestPatientsFrom(String c)*: It returns a list with the patients of the country specified in the input, and sorted so that the ones which have visited the clinic most recently appear first<br>
-*Map<String, Set Patient> patientsByCountry2()*: Same functionality as the first, but implemented with streams instead of loops <br>
-*Map<Integer, Patient> > youngestPatientByYear()*: Returns a dictionary in which the keys are the years in which the patients have visited the clinic, and the values are the youngest patient that have come that year<br>
-*SortedMap<String, List Patient> nMoreWorkInterferePatientsByState(Integer n)*: The keys are the different states (because the mayority of patients are from the USA, and if not, then it is blank) sorted by alphabetical order. And the values are a list of n values (being n the input) sorted according to their WorkInterfere, from greatest to lowest<br>
-*Integer mostRecentUrgentPatientAge()*: It creates an auxiliary map with keys the ages of the patients, and values the patient whose treatment is considered to be urgent and its visit date is the most recent. Then, we use an auxiliary list, with all the patients from the values of the dictionary , sorted according to date, most recent been the first element in the list. At last, using a loop, it returns the age, with is the key that corresponds with the first element of the list<br>
-*Map<Integer, Patient> check()*: same map as the auxiliary in the previous function, whose only purpose is to check that the previous function was working correctly</p>