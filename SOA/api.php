<?php
include_once('cruds.php');

$method = $_SERVER['REQUEST_METHOD'];
$table = $_GET['table'] ?? 'estudiante'; 
$search = $_GET['search'] ?? '';

switch($method) {
    case 'GET':
        if ($table == 'materia') {
            Cruds::selectMat($search);
        } else {
            Cruds::selectEst($search);
        }
        break;

    case 'POST':
        if ($table == 'materia') {
            Cruds::insertMat();
        } else {
            Cruds::insertEst();
        }
        break;

    case 'DELETE':
        if ($table == 'materia') {
            Cruds::deleteMat();
        } else {
            Cruds::deleteEst();
        }
        break;

    case 'PUT':
        if ($table == 'materia') {
            Cruds::updateMat();
        } else {
            Cruds::updateEst();
        }
        break;
    
    default:
        echo json_encode(["error" => "Método no permitido"]);
        break;
}
?>
