# <u>Rest API</u>

------



## User

### /api/user: GET

ex) api/user?id=xx

- id

### /api/user: POST

ex) api/user?username=xx&password=xx..

- username
- password
- email
- nickname
- name

### /api/user: PUT

- id
- username
- password
- email
- nickname
- name

### /api/user: DELETE

- id

------



## Tripcart

### /api/tripcart: GET

- id

### /api/tripcart: POST

- user_id
- division_id
- serial_num

### /api/tripcart: PUT

- id
- user_id
- division_id
- serial_num

### /api/tripcart: DELETE

- id

------

## Division

### /api/division: GET

- id

### /api/division: POST

- name

### /api/tripcart: PUT

- id
- name

### /api/tripcart: DELETE

- id