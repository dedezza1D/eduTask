-- Create Users table
CREATE TABLE Users (
  id SERIAL PRIMARY KEY,  -- campo de ID adicionado
  keycloak_id UUID UNIQUE NOT NULL,
  username VARCHAR(255) UNIQUE NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  role VARCHAR(50) NOT NULL,
  enabled BOOLEAN DEFAULT FALSE NOT NULL
);

-- Create Teams table
CREATE TABLE Teams (
  team_id SERIAL PRIMARY KEY,
  team_name VARCHAR(255) UNIQUE NOT NULL
);

-- Create Tasks table
CREATE TABLE Tasks (
  task_id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  due_date DATE,
  priority INTEGER,
  status VARCHAR(50),
  user_id INTEGER,
  FOREIGN KEY (user_id) REFERENCES Users(id)  -- atualizado para referenciar 'id' ao invés de 'user_id'
);

-- Create Assignments table
CREATE TABLE Assignments (
  assignment_id SERIAL PRIMARY KEY,
  task_id INTEGER,
  user_id INTEGER,
  team_id INTEGER,
  status VARCHAR(50),
  FOREIGN KEY (task_id) REFERENCES Tasks(task_id),
  FOREIGN KEY (user_id) REFERENCES Users(id),  -- atualizado para referenciar 'id' ao invés de 'user_id'
  FOREIGN KEY (team_id) REFERENCES Teams(team_id)
);

-- Create Submissions table
CREATE TABLE Submissions (
  submission_id SERIAL PRIMARY KEY,
  task_id INTEGER,
  user_id INTEGER,
  submission_date DATE,
  submitted_file VARCHAR(255),
  FOREIGN KEY (task_id) REFERENCES Tasks(task_id),
  FOREIGN KEY (user_id) REFERENCES Users(id)  -- atualizado para referenciar 'id' ao invés de 'user_id'
);

-- Create GradesFeedback table
CREATE TABLE GradesFeedback (
  grade_id SERIAL PRIMARY KEY,
  task_id INTEGER,
  user_id INTEGER,
  grade_content TEXT,
  date DATE,
  FOREIGN KEY (task_id) REFERENCES Tasks(task_id),
  FOREIGN KEY (user_id) REFERENCES Users(id)  -- atualizado para referenciar 'id' ao invés de 'user_id'
);

-- Create LearningResources table
CREATE TABLE LearningResources (
  resource_id SERIAL PRIMARY KEY,
  title VARCHAR(255),
  description TEXT,
  file_url VARCHAR(255),
  task_id INTEGER,
  upload_date DATE,
  FOREIGN KEY (task_id) REFERENCES Tasks(task_id)
);
