<?php

class Conexion{
    public function Conectar(){
        $server = 'localhost';
        $user = 'root';
        $password="";
        $database="soapractica";

        try{
            $conn=new PDO("mysql:host=$server;dbname=$database;",$user,$password);
        }catch(Exception $e)
        {
            die("Fallo conexión".$e->getMessage());
        }
        return $conn;
    }
}

?>