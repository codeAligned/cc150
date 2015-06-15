Denormalized vs. Normalized Databases
Normalized databases are designed to minimize redundancy, while denormalized databases are designed to optimize read time.

In a traditional normalized database with data like Courses and Teachers, Courses might contain a column called TeacherId,
which is a foreign key to Teacher. One benefit of this is that information about the teacher(name, address, etc) is only
stored once in database. The drawback is that many common queries will require expensive joins.

Instead, we can denormalize the database by storing redundant data. For example, if we knew that we would have to repeat this
query often, we might store the teacher name in the Courses table. Denormalization is commonly used to create highly scalable
systems.


SQL Statements
Couses: CourseID*, CourseName, TeacherID
Teachers: TeacherID*, TeacherName
Students: StudentID*, StudentName
StudentCourses: CourseID*, StudentID*

Query 1: Student Enrollment
Implement a query to get a list of all students and how many courses each student is enrolled in.

At first,
SELECT Students.Studentname, count(*)
FROM Students INNER JOIN StudentCourses
ON Students.StudentID = StudentCourses.StudentID
GROUP BY Students.StudentID

This has three problems:
1 we have excluded students who are not enrolled in any courses. We need to change this to a LEFT JOIN

2 Doing count(*) would return how many items there are in a given group of StudentIDs. Students enrolled in zero courses would still
have one item in their group. We need to change this to count the number of CourseIDs in each group: count(StudentCourses.CourseID)

3 We have grouped by Students.StudentID, but there are still multiple StudentNames in each group. We need to apply an aggregate function
to this, such as first(Students.StudentName)

Fixing these issues gets us to this query:
SELECT StudentName, Students.StudentID, Cnt
FROM (
	SELECT Students.StudentID,
					count(StudentCourses.CourseID) as [Cnt]
	FROM Students LEFT JOIN StudentCourses
	ON Students.StudentID = StudentCourses.StudentID
	GROUP BY Students.StudentID
) T INNER JOIN Students on T.studentID = Students.StudentID

Alternatively, Solution 2
SELECT StudentName, Students.StudentID, count(StudentCourses.CourseID) as [Cnt]
FROM Students LEFT JOIN StudentCourses
ON Students.StudentID = StudentCourses.StudentID
GROUP BY Students.StudentID, Students.StudentName

Solution 3

SELECT max(StudentName) as [StudentName], Students.StudentID, count(StudentCourses.CourseID) as [Cnt]
FROM Students LEFT JOIN StudentCourses
ON Students.StudentID = StudentCourses.StudentID
GROUP BY Students.StudentID


Query 2: Teacher Class Size
Implement a query to get a list of all teachers and how many students they each teach.

First, get a list of TeacherIDs and how many students are associated with each TeacherID.
SELECT TeacherID, count(StudentCourses.CourseID) AS [Number]
FROM Courses INNER JOIN StudentCourses
ON Courses.CourseID = StudentCourses.CourseID
GROUP BY Courses.TeacherID

Note that this INNER JOIN will not select teachers who are not teaching classes.

SELECT TeacherName, isnull(StudentSize.Number, 0)
FROM Teachers LEFT JOIN
	(SELECT TeacherID, count(StudentCourses.CourseID) AS [Number]
		FROM Courses INNER JOIN StudentCourses
		ON Courses.CourseID = StudentCourses.CourseID
		GROUP BY Courses.TeacherID) StudentSize
ON Teachers.TeacherID = StudentSize.TeacherID
ORDER BY StudentSize.Number DESC


Small Database Design
Step 1: Handle Ambiguity

Step 2: Define the Core Objects

Step 3: Analyze Relationships

Step 4: Investigate Actions


Large Database Design
When designing a large, scalable database, joins are generally very slow. Thus you must denormalize your data. You will probably need to
duplicate the data in multiple tables.

















