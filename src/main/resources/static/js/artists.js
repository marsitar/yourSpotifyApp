$(function () {
  $(document).ready(function () {
    $("#searchByName").click(function (event) {
      let artistName = $('#searchArtist').val();
      $.ajax({
        url: '/browser_artist?artist_name=' + artistName,
        type: 'GET',
        success: function () {
          window.location.href = '/browser_artist?artist_name=' + artistName
          ;
        }
      });
    });
  });
});

$(function () {
  $(document).ready(function () {
    $(".del_artist").click(function (event) {
      var buttonId = $(event.target).attr('data-id');
      $.ajax({
        url: "/favourite_artist",
        method: "DELETE",
        data: {artist_id: buttonId},
        success: function () {
          location.reload();
        },
        error: function (error) {
          alert('Error! Artist has not been deleted');
        }
      });
    });
  });
});

$(function () {
  $(document).ready(function () {
    $(".add_artist").click(function (event) {
      var buttonId = $(event.target).attr('data-id');
      $.ajax({
        url: "/favourite_artist",
        method: "POST",
        data: {artist_id: buttonId},
        success: function () {
          location.reload();
        },
        error: function (error) {
          alert('Error! Artist has not been added');
        }
      });
    });
  });
});