A Simple Words statistics application


Workflow notes:

Setup Java (1.6 or higher, openjdk if Debian/Ubuntu)
Setup Maven 3.0.3

MongoDB setup
 Download MongoDB
 Run as mongod --dbpath=/some/local/data/dir
 From a new terminal, test that mongo connect to the database

Application setup
  Create heroku account using email for collaboration
  cd /home/username/work
  mkdir WordGlass
  cd WordGlass/
  heroku login (enter your login from heroku account)
  git pull heroku
  mvn package
  export PORT=5000
  export MONGOHQ_URL=mongodb://:@localhost:27017/test (for mongodb database called 'test')

Testing app locally
  java -cp target/classes:"target/dependency/*" HelloWorld
  browser point to http://localhost:5000  

Deploying changes  (No staging right now, directly to production!)
  Make changes, test
  git status 
  git add fileOrDir
  git commit -m "notes"
  git push heroku master
  Ensure application is still running at http://wordglass.herokuapp.com
