printf  "%s\n" "----------------------1-------------------------"
printf  "%s\n" "Find movies wich are shows that day and around this time(+/-1hour):"
curl -X GET 'http://localhost:8080/client/find-screenings?date=2020-03-01&startTime=15:00:00'

printf  "%s\n" "----------------------2-------------------------"
printf  "%s\n" "Get info about chosen screening: "
curl -X GET 'http://localhost:8080/client/get-screening?date=2020-03-01&time=15:00:00&title=Harry%20Potter'

printf  "%s\n" "----------------------3-------------------------"
printf  "%s\n" "Reserve tickets:"
curl -X POST 'http://localhost:8080/client/create-tickets/C3,C4/ADULT,STUDENT?date=2020-03-01&time=15:00:00&title=Harry%20Potter&firstName=Roman&secondName=Czerski'

printf  "%s\n" "----------------------4-------------------------"
printf  "%s\n" "Reserve tickets with double surname:"
curl -X POST 'http://localhost:8080/client/create-tickets/E3,E4/ADULT,STUDENT?date=2020-03-01&time=15:00:00&title=Harry%20Potter&firstName=Alicja&secondName=Pomorska-Stonoga'

printf  "%s\n" "----------------------5-------------------------"
printf  "%s\n" "Get info about chosen screening (the list of seats has change):"
curl -X GET 'http://localhost:8080/client/get-screening?date=2020-03-01&time=15:00:00&title=Harry%20Potter'

printf  "%s\n" "----------------------6-------------------------"
printf  "%s\n" "When you give uncorrect name:"
curl -X POST 'http://localhost:8080/client/create-tickets/C3,C4/ADULT,STUDENT?date=2020-03-01&time=15:00:00&title=Harry%20Potter&firstName=Ro&secondName=Czerski'

printf  "%s\n" "----------------------7-------------------------"
printf  "%s\n" "When you give wrong seat number:"
curl -X POST 'http://localhost:8080/client/create-tickets/C12,C5/ADULT,STUDENT?date=2020-03-01&time=15:00:00&title=Harry%20Potter&firstName=Czarek&secondName=Powalski'

printf  "%s\n" "----------------------8-------------------------"
printf  "%s\n" "When you try to reserve already taken seat:"
curl -X POST 'http://localhost:8080/client/create-tickets/C3,C4/ADULT,STUDENT?date=2020-03-01&time=15:00:00&title=Harry%20Potter&firstName=Czarek&secondName=Powalski'

printf  "%s\n" "----------------------9-------------------------"
printf  "%s\n" "When you try to reserve seats leaving single seat on the side:"
curl -X POST 'http://localhost:8080/client/create-tickets/C6,C7/ADULT,STUDENT?date=2020-03-01&time=15:00:00&title=Harry%20Potter&firstName=Czarek&secondName=Powalski'

printf  "%s\n" "----------------------10-----------------------"
printf  "%s\n" "When you try to reserve seats leaving single seat in the middle of your seats:"
curl -X POST 'http://localhost:8080/client/create-tickets/D6,D8,D9/ADULT,STUDENT,CHILD?date=2020-03-01&time=15:00:00&title=Harry%20Potter&firstName=Czarek&secondName=Powalski'