CS542 Design Patterns
Fall 2016
PROJECT <2> README FILE

Due Date: <Tuesday, August 30, 2016>
Submission Date: <Friday, September 30, 2016>
Grace Period Used This Project: <10> Days
Grace Period Remaining: <0> Days
Author(s): <Yunpeng Ge>
e-mail(s): <yge6@binghamton.edu> 


PURPOSE:

  Learn how threads work simultaneously.
  How to use Object Pool.
  How to handle mix of I/O.

PERCENT COMPLETE:

  I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:

  I believe there should not be anything uncompleted.

BUGS:

  None.

FILES:

  Included with this project are 14 files:

  /src/registrationScheduler/driver/
  Driver.java

  /src/registrationScheduler/store/
  Student.java
  Course.java
  Entity.java
  FileDisplayInterface.java
  ObjectPool.java
  Results.java
  StdoutDisplayInterface.java

  /src/registrationScheduler/threadMgmt/
  CreateWorkers.java
  WorkerThread.java

  /src/registrationScheduler/util/
  FileProcessor.java
  Logger.java

  /src/
  build.xml

  README.txt

DATA STRUCTURE:
  A Student class that contain his or her preference for each course and whether he  or she has gotten each course, and also some member functions.
  A Course class implements ObjectPool interface.
  An Entity class that contain 7 courses.

TIME COMPLEXITY:
  O(student_number).

SPACE COMPLEXITY:
  O(student_number + course_number).

SAMPLE OUTPUT:

  [a…@a…-mac:~/…/bin]$ ant -buildfile src/build.xml registrationScheduler  

  BUILD SUCCESSFUL
  Total time: 0 seconds

  [a…@a…-mac:~/…/bin]$ ant -buildfile src/build.xml run -Darg0=input-1.txt -Darg1=output-1.txt -Darg2=3 -Darg3=0

  Average preference_score is: 15.0125

TO COMPILE:

  ant -buildfile src/build.xml registrationScheduler

TO RUN:

  ant -buildfile src/build.xml run -Darg0=input-1.txt -Darg1=output-1.txt -Darg2=3 -Darg3=0

ACKNOWLEDGEMENT:

  I finished this project totally by myself.
