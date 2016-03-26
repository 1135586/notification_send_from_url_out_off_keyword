add to cronjob (every 5 minutes):

1. crontab -e

    */5 * * * * /usr/bin/java -cp <PATH_TO_FILE>:. App
