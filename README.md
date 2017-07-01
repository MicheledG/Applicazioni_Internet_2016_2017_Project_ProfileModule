# Profile Microservice - Internet Applications Project

The Profile Microservice part of the final project for Internet Applications course held at Polytechnic University of Turin by Prof. Malnati and Prof. Servetti (a.y. 2016/2017).

## Usage

This microservice requires authentication for any request. 

Authentication is based on a token (JWT), obtained by providing the right credentials to the Authentication Microservice.

The authentication token must be placed in the http request as `Authentication` header:

`Authentication: Bearer XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX	` 

## REST Services

### Profile

| API	               | Method | Req. body  | Query params | Status | Resp. body | Meaning    					  |
|:--------------------:|:------:|:----------:|:------------:|:------:|:----------:|:-------------------------------|
| `/profile`           | `GET`  |            |              | 200    | profile    | Get the profile of the current logged user |
| `/profile`           | `POST` | username, nickname |              | 201    |            | Create a profile for a new registered user |
|                      |        |            |              | 409    |            | A profile for the same username already exists |
| `/profile`           | `PUT`  | profile    |              | 200    | profile    | Update the profile of the current logged user |
|                      |        |            |              | 404    |            | A profile for the requested username doesn't exist |
| `/profile/nickname`  | `GET`  |            | username     | 200    | nickname   | Get the nickname associated to the username param |
|                      |        |            |              | 404    |            | A profile for the requested username doesn't exist |