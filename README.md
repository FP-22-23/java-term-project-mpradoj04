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

# Base type - Patient

Represents the data about a patient

**\<Properties>**

name, type <String>, searchable and modifiable. The name of the patient.
nPatient, type <int>, searchable and modifiable. The number of the patient (simbolizes order of treatment).
date, type <LocalDateTime>, searchable. When did the patient got the examination.
age, type <int>, searchable. The age of the patient.
gender, type<Gender> searchable and modifiable. Indicates the gender of the patient. Can take the values MAN,WOMAN.
country, type<String> searchable and modifiable. Their country of birth.
state, type<String> searchable. If they're from the USA, it shows what state they're from.
treatment, type<Treatment> searchable and modifiable. Shows with two boolean values if they have family record, and if they are taking some kind of treatment.
workInterfere, type<Double> searchable and modifiable. As greater the number, greater the implication its work has with their personal live.
employ, type<Employ>, searchable. Indicates what kind of work they are in. Can take the values UNKNOWN,UNEMPLOYED,WORKER,SELFEMPLOYED.
remoteW, type<boolean>, searchable and modifiable. True if they work from home, false otherwise.
comentaries, type<List<String>> searchable and modifiable. Some comentaries about the characteristics of the patient.

**\<Constructors>**

C1: Has a parameter for each basic property of the type.
C2: Creates a type ```Patient``` from the following parameters ```String name, int nPatient, int age, Treatment treatment```.
C3: Creates a type ```Patient``` from a String.

**\<Restrictions>**

R1: the name of the patient cannot be empty.
R2: the age of the patient cannot be less than 5 years.
R3: the date of the examination must be after year 2014 (included).

***Equality criterium**: Two patients are equal if all their basic properties are equal.

***Order criterium**: First by date, then by name.

***Other operations**:

- _: Descripción del método 1.

# Auxiliary type - Treatment

One of the basic properties in Patient

**\<Properties>**

fRecord, type<boolean>, searchable and modifiable. True if he/she has family record , false if he/she doesn't
treatment, type<boolean>, searchable and modifiable.. True if he/she takes medication, false if he/she doesn't

**\<Constructors>**

C1: Has a parameter for each basic property of the type.
C2: Doesn't take parameters.

***Equality criterium**: Two treatments are equal if all their basic properties are equal.

***Other operations**:

-boolean isUrgent. Which takes no atributes, and depending on the values of the basic properties of Treatment, it will return true if the patient condition is critical, false otherwise

#### Auxiliary types

- Gender, enumerated. Takes the values MAN,WOMAN.
- Employ, enumerated. Takes the values UNKNOWN,UNEMPLOYED,WORKER,SELFEMPLOYED.
- Treatment, mentioned before



Factoría
Descripción breve de la factoría.

método 1: Descripción del método 1.
método 2: Descripción del método 2.
Tipo Contenedor
Descripción breve del tipo contenedor.

Propiedades:

propiedad1, de tipo <Tipo1>, consultable.
propiedad2, de tipo <Tipo2>, consultable y modificable.
...
Constructores:

C1: Descripción del constructor 1.
C2: Descripción del constructor 2.
...
Restricciones:

R1: Descripción de la restricción 1.
R2: Descripción de la restricción 2.
...
Criterio de igualdad: Describir el criterio de igualdad

Criterio de ordenación: Describir el criterio de ordenación (si lo hay).

Otras operaciones:

método 1: Descripción del método 1.
...