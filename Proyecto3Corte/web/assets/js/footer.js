/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    var html = $('#errorLogin').html().replace(/ /g, '');
    if (html == '') {
        $('#errorLogin').removeClass('alert alert-danger');
    }
});