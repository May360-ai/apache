<?php
include_once("conexion.php");

class Cruds {
    // ESTUDIANTES
    public static function selectEst($search = "") {
        $objConexion = new Conexion();
        $conectar = $objConexion->Conectar();
        
        if ($search) {
            $sqlSelect = "SELECT * FROM estudiante WHERE cedula LIKE :search OR nombre LIKE :search OR apellido LIKE :search";
            $resultado = $conectar->prepare($sqlSelect);
            $searchTerm = "%$search%";
            $resultado->bindParam(':search', $searchTerm);
        } else {
            $sqlSelect = "SELECT * FROM estudiante";
            $resultado = $conectar->prepare($sqlSelect);
        }
        
        $resultado->execute();
        $data = $resultado->fetchAll(PDO::FETCH_ASSOC);
        echo json_encode($data);
    }

    public static function insertEst() {
        $objConecction = new Conexion();
        $conn = $objConecction->Conectar();
        
        $cedula = $_POST['txtCedula'] ?? '';
        $nombre = $_POST['txtNombre'] ?? '';
        $apellido = $_POST['txtApellido'] ?? '';
        $telefono = $_POST['txtTelefono'] ?? '';
        $direccion = $_POST['txtDireccion'] ?? '';
        
        $sqlInsert = "INSERT INTO estudiante (cedula, nombre, apellido, telefono, direccion) VALUES (:cedula, :nombre, :apellido, :telefono, :direccion)";
        $resultado = $conn->prepare($sqlInsert);
        $resultado->execute([
            ':cedula' => $cedula,
            ':nombre' => $nombre,
            ':apellido' => $apellido,
            ':telefono' => $telefono,
            ':direccion' => $direccion
        ]);

        echo json_encode("Se inserto correctamente el estudiante");
    }

    public static function deleteEst() {
        $objConecction = new Conexion();
        $conn = $objConecction->Conectar();   
        $cedula = $_GET['txtCedula'] ?? '';
        
        $sqlDelete = "DELETE FROM estudiante WHERE cedula = :cedula";
        $resultado = $conn->prepare($sqlDelete);
        $resultado->execute([':cedula' => $cedula]);

        echo json_encode("Se elimino correctamente el estudiante");
    }

    public static function updateEst() {
        $objConecction = new Conexion();
        $conn = $objConecction->Conectar();
        
        $cedula = $_GET['txtCedula'] ?? '';
        $nombre = $_GET['txtNombre'] ?? '';
        $apellido = $_GET['txtApellido'] ?? '';
        $telefono = $_GET['txtTelefono'] ?? '';
        $direccion = $_GET['txtDireccion'] ?? '';
        
        $sqlUpdate = "UPDATE estudiante SET nombre = :nombre, apellido = :apellido, telefono = :telefono, direccion = :direccion WHERE cedula = :cedula";
        $resultado = $conn->prepare($sqlUpdate);
        $resultado->execute([
            ':cedula' => $cedula,
            ':nombre' => $nombre,
            ':apellido' => $apellido,
            ':telefono' => $telefono,
            ':direccion' => $direccion
        ]);

        echo json_encode("Se actualizo correctamente el estudiante");
    }

    // MATERIAS
    public static function selectMat($search = "") {
        $objConexion = new Conexion();
        $conectar = $objConexion->Conectar();
        
        if ($search) {
            $sqlSelect = "SELECT * FROM materia WHERE id LIKE :search OR nombre LIKE :search";
            $resultado = $conectar->prepare($sqlSelect);
            $searchTerm = "%$search%";
            $resultado->bindParam(':search', $searchTerm);
        } else {
            $sqlSelect = "SELECT * FROM materia";
            $resultado = $conectar->prepare($sqlSelect);
        }
        
        $resultado->execute();
        $data = $resultado->fetchAll(PDO::FETCH_ASSOC);
        echo json_encode($data);
    }

    public static function insertMat() {
        $objConecction = new Conexion();
        $conn = $objConecction->Conectar();
        
        $id = $_POST['txtIdMateria'] ?? '';
        $nombre = $_POST['txtNombreMateria'] ?? '';
        $estudiante = $_POST['txtCedulaEstudiante'] ?? '';
        
        $sqlInsert = "INSERT INTO materia (id, nombre, estudiante) VALUES (:id, :nombre, :estudiante)";
        $resultado = $conn->prepare($sqlInsert);
        $resultado->execute([
            ':id' => $id,
            ':nombre' => $nombre,
            ':estudiante' => $estudiante
        ]);

        echo json_encode("Se inserto correctamente la materia");
    }

    public static function deleteMat() {
        $objConecction = new Conexion();
        $conn = $objConecction->Conectar();   
        $id = $_GET['txtIdMateria'] ?? '';
        
        $sqlDelete = "DELETE FROM materia WHERE id = :id";
        $resultado = $conn->prepare($sqlDelete);
        $resultado->execute([':id' => $id]);

        echo json_encode("Se elimino correctamente la materia");
    }

    public static function updateMat() {
        $objConecction = new Conexion();
        $conn = $objConecction->Conectar();
        
        $id = $_GET['txtIdMateria'] ?? '';
        $nombre = $_GET['txtNombreMateria'] ?? '';
        $estudiante = $_GET['txtCedulaEstudiante'] ?? '';
        
        $sqlUpdate = "UPDATE materia SET nombre = :nombre, estudiante = :estudiante WHERE id = :id";
        $resultado = $conn->prepare($sqlUpdate);
        $resultado->execute([
            ':id' => $id,
            ':nombre' => $nombre,
            ':estudiante' => $estudiante
        ]);

        echo json_encode("Se actualizo correctamente la materia");
    }
}
?>
