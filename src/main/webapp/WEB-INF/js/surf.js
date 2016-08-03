/*
 * various functions for surf video'

 Jan-Juc-Surf-Report/1066/

 Key: 7e843d83069fb454ab0928394ee068b1
 Secret: 546c12eb1799d335928e0caf98f4c517

 http://magicseaweed.com/api/7e843d83069fb454ab0928394ee068b1/forecast/?spot_id=1066


 */

//$.getScript('https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js');


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
        url : "videos.txt",
	    success : function(jsonData) {
	          var videos = $.parseJSON(jsonData);
            
	          populateSelectList("#vidselector", videos);
              $("#vidselector").change(function(data) {
                 $("#video").attr("src", $("#vidselector").val());
              });
	    }
	 });

     $.ajax({
           url: 'https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js',
           dataType: "script",
           success:  function() {
                   $('select').select2({
                      placeholder: 'Select an option'
                   });
           }
     });


     var magicseaweed = {
         msKey  : "7e843d83069fb454ab0928394ee068b1",
         spotId : "1066", // Jan Jac
         locale : "eu",
         url    : function() {
             return "http://magicseaweed.com/api/";
         },
         data   : function() {
             return this.msKey + "/forecast/?spot_id=" + this.spotId + "&units=" + this.locale + "&localTimestamp=" + '1469263397';
         }
      }

//      var jqxhr = $.getJSON( magicseaweed.url() + magicseaweed.data(), function() {
//        console.log( "success" );
//      })
//      .done(function() {
//        console.log( "second success" );
//      })
//      .fail(function() {
//        console.log( "error" );
//      })
//      .always(function() {
//        console.log( "complete" );
//      });


      $.ajax({
         url : magicseaweed.url(),
         dataType: "json",
         data    : magicseaweed.data(),
         success : function(data) {
            var prediction = $.parseJSON(data);
            console.log('success');
         },
         error : function(jqXHR, textStatus, errorThrown) {
             alert("could not get surf prediction " + textStatus + ": errorThrown=" + errorThrown + ": url=" + magicseaweed.url());
         },

         xhrFields: {
                 withCredentials: true
         }
      });
});


