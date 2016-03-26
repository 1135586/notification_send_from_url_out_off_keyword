add to cronjob (every 5 minutes):

1. crontab -e

    */5 * * * * /usr/bin/java -cp <PATH_TO_FILE>:. App

2. to works properly need that crontab includes the String below
    DISPLAY=:0.0
