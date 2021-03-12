#Assignment_02_CSE468.1_S01


Due Date : 02.04.2021   
Name : Abdullah Al Sayem
ID : 1721655642
Course : CSE486
Section : 01
Lab Instructor : Marufa Ferdausi
Course Faculty : Shaikh Shawon Arefin Shimon



ASSIGNMENT INSTRUCTIONS:

1. Create an application that takes the following input from a NSU Student
   a. Name according to NSU ID
   b. 7 Digit Student ID
   c. School (Use a dropdown list)
       i. This dropdown list should be defined in the resources section and not hardcoded.
   d. Department (Use a dropdown list)
       i. This dropdown list should be defined in the resources section.
      ii. Department list should be specific to each school.
   e. Date of Birth
       i. Use a date picker
   f. Phone number
       i. Should be Bangladeshi phone number format
   g. NID number
       i. NID number should be in the new format.
      ii. If the number does not match NID number format (10 digit), a error message should be displayed.
   h. Present Address
       i. Country
      ii. District
     iii. Post Office
      iv. Police Station
       v. Postal Code
      vi. House/Village/City
     vii. Road/Block/Sector
   i. Permanent Address
       i. Country
      ii. District
     iii. Post Office
      iv. Police Station
       v. Postal Code
      vi. House/Village/City
     vii. Road/Block/Sector


2. Divide the input into multiple activities. Each activity should have a forward and back button. When the user clicks on submit button, Save the input data into a local SQL database using Room. (https://developer.android.com/training/data-storage/room)


3. Add another activity showing vertical list of 7 digit student IDs using RecyclerView. This list should be extracted from the SQL database using Room. When one item on the list is tapped, the Name and Department of the student should be shown in a popup message.


4. Add another activity with advanced search feature. This activity allows you to filter students matching a set of criteria extracted from the above input. You have the flexibility to decide how you want to implement this search feature.


5. Add Bangla language support for this app for every label, button and options. This can be done from here : Language Support.(https://developer.android.com/training/basics/supporting-devices/languages) 
