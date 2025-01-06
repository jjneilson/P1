
#

## Employee Reimbursement System

This is a web application made to simplify the process of requesting a reimbursment by creating a method of submitting, managing, and approving reimbursements.

### Tech Stack

#### Front-End

- React --> Used to make a fast responsive front end SPA.
- Tanstack Router --> Handles client-side routing on the frontend of the application to navigate between login, registration, and various dashboards.
- Tailwind CSS --> Used to simplify the use of css to make development faster.
- Shadcn --> Further increase to development speed through premade react assets for frontend UI.

#### API Connections

- Axios --> Used to steamline the http requests made to the backend.
- Tanstack Query --> Handles the fetches of data along with synchronization and changes.

#### Back-End

- Java with Spring Boot
- Postgres SQL Database

#### Other Tools Used

- React Component Profiler -> Used to verify easily that certain components worked as intended and rendered on page
- Postman -> Used for original backend testing to verify endpoints worked and later used to debug frontend calls

### Application Architecture

- **Roles**:  
  - *Employee*: Submit and track reimbursement requests.  
  - *Manager*: Anything employees can do and Review, approve, or deny requests.

  - **Workflow Overview**:  
  1. Employees log in, submit, or edit their reimbursement requests via the web interface.
  2. Reimbursements are processed by the back end after any update or submition.
  3. Managers log in to review and take action (approve/deny or delete) on the reimbursements.
  4. Users can log in and check the real-time status of their reimbursement requests.

- **ERD**:
  
  ![image](https://drive.google.com/uc?export=view&id=1dxlCZ6-cbXwdNL_8eLVQ_pJvOM4YzaKN)

### Challenges and Knowledge Gained

#### Challenges

- **Front End Styling and Accessibility**:  
  - Solved through the use of Shadcn and Tailwind CSS to make a more clean looking frontend as I have made react websites before but only with simple css styling.

- **TanStack**:  
  - I have never used either Tanstack Query or Tanstack Router so I had to rely on online examples and the documentation to guide me until I had a good understanding of both.

#### Knowledge Gained

- Solidified my knowledge of spring-boot and java based backend concepts along with adding new knowledge of JWT and authentication use in the backend.
- Refreshed my react knowledge from a couple of years ago and gained the understanding of how to do routing and queries with helpful tools like TanStack.
- Worked on my styling skills with the use of Tailwind CSS and Shadcn to be faster and have to look up less.

### Future Improvements
  
- Create docker images for all parts of the project as to allow for consistent deployments.
- Implement email based registration to allow for account creation verifcation and notifcations about reimbursments.
- Use created docker images for cloud platform deployment to increase scalability.
- Fix minor issues in certain parts of application that do not update without a refresh of the page.
