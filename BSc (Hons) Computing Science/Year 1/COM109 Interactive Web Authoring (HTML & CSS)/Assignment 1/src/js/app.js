$(document).ready(function(){

    /* Leaderboard Animation */
    $('#li1').css('opacity','0')
    $('#li2').css('opacity','0')
    $('#li3').css('opacity','0')
    $('#li4').css('opacity','0')
    $('#li5').css('opacity','0')

    $('#nameError').hide()
    $('#scoreError').hide()

    var currentLi = 1

    $('body').click(function(){
        $('#li'+currentLi).animate({
            opacity:"1"
        });
        currentLi += 1
    });


    /* Toggle New Information */
    $('#footerFieldset').hide()
    $('#btnNewInformation').click(function(){
        $('#footerFieldset').toggle({
            opacity: "1"
        });
    });

    /* Add New Item To List */

    $('#btnSubmit').click(function(){
        $('#nameError').hide()
        $('#scoreError').hide()

        var Name = $('#addName').val()
        var Score = $('#addScore').val()

        var error = false;

        var newLi = 6

        if(Name.length < 4) {
            $('#nameError').show()
            error = true;
        }

        if(Score < 0 || Score > 100) {
            $('#scoreError').show()
            error = true;
        }

        if(isNaN(Score)) {
            $('#scoreError').show()
            error = true;
        }

        if(error) {
            alert('Error! Please check the information you have entered is valid.')
        }
        else {
            $('#olItem').append('<li class="liItem" id="li' + newLi + '">' + '<span class="pName">' + Name + '</span>' + '<span class="pScore">' + Score + '</span>' + '</li>')

            $('#li1').css('opacity','1')
            $('#li2').css('opacity','1')
            $('#li3').css('opacity','1')
            $('#li4').css('opacity','1')
            $('#li5').css('opacity','1')

            newLi += 1
        }
    });
});