/*
 * various functions for surf video'
 */



/**
 * adds a option to a select list.
 */
function addOptions(selectMenu, key, value) {
   $(selectMenu).append($("<option></option>")
      .attr("value",value)
      .text(key));

}

/**
 * populate select list
 */
function populateSelectList(selectList, data) {
    $.each(data.videos, function(index, obj) {
        addOptions(selectList, obj.vidname, obj.srcLocation);
    });
}

/**
 * Create page load function.
 */
$(document).ready( function() {

     $.ajax({
           url: 'https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js',
           dataType: "script",
           success:  function() {
                   $('select').select2({
                      placeholder: 'Select an option'
                   });
           }
     });

     $("#vidselector").change(function(data) {
        $("#video").attr("src", $("#vidselector").val());
     });

});


