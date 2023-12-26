package com.dam.users.models

import java.io.Serializable

class User(var correo : String, var pass : String, var perfil : String, var visibilidad : String) : Serializable {
}