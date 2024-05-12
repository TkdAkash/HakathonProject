Project Name : IdentifyCourses

Overview : This is a Java based Selenium project that automates testing on Coursera website.It includes TestNG framework for testing, and used PageFactory in order to support POM(Page Object Model design). Implemented cross browsing on Google Chrome and Microsoft Edge. Extent Report is also generated.

Requirements :
    • Requirement 1: Web Development Courses for Beginners
        1) Navigate to a Coursera online learning platform.
        2) In the search bar, type “Web Development Courses"and hit enter.
	3) Select "English" in Language and "Beginner" in Levels.
        4) From the search results, get the following from first two courses. 
           •Note down the course name.
	   •Check the course rating.
           •Look for the total learning hours and details of the course.
      
    • Requirement 2: Language Learning
        1) Navigate to the “Language Learning” section of the online learning platform.
        2) Extract all the languages available for learning.
        3) Identify and extract the different levels (e.g., Beginner, Intermediate, Advanced).

    • Requirement 3: Courses for Campus under Product
        1) From the home page of the online learning platform, navigate to the “For Enterprise” section.
        2) Look for “Courses for Campus” under the “Product” category.
        3) Fill the form “Ready to transform” with one incorrect detail.
        4) Submit the form and capture the error message displayed.

Dependencies :
• Selenium: <4.19.1>
• TestNG: <7.10.1>
• ExtentReports: <5.1.1>


Programming Language :
•Java

Framework:
•TestNG

Tool:
• Maven
• Selenium