# Galway Library
## System Goals
The pair programming project introduces a library management system for borrwing/returning books, adding members, finding out what books are available to rent and books that are currently borrowed. Also, the system has the ability to search for books too. Books are identified by a unique number (ISBN).
## Agile Planning

This project was developed using agile methodologies by delivering small features in incremental sprints.
## The-Scope-Plane

* Ability to perform CRUD functionality on books and members
## The-Structure-Plane

### Features

**Navigation Menu**
The following navigation items are available command line interface:
  * Add a new book
  * Register a library member
  * Borrow a book
  * Return a book
  * View all available books
  * View all members
  * Search for a book
  * Exit

## Clean Architecture
The system follows clean architecture principles by storing files in the appropriate folders:
  * src/
     adapters/
      LibraryRepository.java
  * src/
     entities/
      Book.java
      BookStatus.java
      BorrowRecord.java
      Member.java
  * src/
     frameworks/
      InMemoryLibraryRepository.java
  * src/
     main/
      Library.java
  * src/
     usecases/
      AddBookUseCase.java
      BorrowBookUseCase.java
      ListBooksUseCase.java
      RegisterMemberUseCase.java
      ReturnMemberUseCase.java
      ReturnBookUseCase.java
      SearchBookUseCase.java
     
## SOLID Principles
Each class in the entities folder adhered to the S principle by only having one responsibility and keeping all functionality related. The O principle was applied to the ReturnBookUseCase.java file in the usecases folder. The L principle was applied to the Member.java file. The file in the adapters folder adheres to the I principle. The D principle was used by the InMemoryLibraryRepository.java file in the frameworks folder
