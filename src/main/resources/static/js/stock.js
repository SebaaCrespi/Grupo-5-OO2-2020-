$('#marca').change(() => {
    var marca = $('#marca').val();
    $.ajax({
        method: "GET",
        url: "/sucursal/filter/"+marca
    })
    .done((result) => {
        $('#descripcion').html(result);
    })
    .fail(()=>{
        alert("Error");
    });
});
$('#descripcion').change(() => {
    var marca = $('#marca').val();
    var descripcion = $('#descripcion').val();
    $.ajax({
        method: "GET",
        url: "/sucursal/filter/"+marca+'/'+descripcion
    })
    .done((result) => {
        $('#talle').html(result);
    })
    .fail(()=>{
        alert("Error");
    });
});
$('#buscar').click(() => {
    var id = $('#idSucursal').val();
    var marca = $('#marca').val();
    var descripcion = $('#descripcion').val();
    var talle = $('#talle').val();
    $.ajax({
        method: "GET",
        url: "/sucursal/filter/"+id+"/"+marca+"/"+descripcion+"/"+talle
    })
    .done((result) => {
        $('#lotes').html(result);
    })
    .fail(()=>{
        alert("Error");
    });
});