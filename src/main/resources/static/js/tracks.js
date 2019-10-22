$(function () {
  $(document).ready(function () {
    $("#searchByName").click(function (event) {
      let artistName = $('#searchTrack').val();
      $.ajax({
        url: '/browser_track?track_name=' + artistName,
        type: 'GET',
        success: function () {
          window.location.href = '/browser_track?track_name=' + artistName
          ;
        }
      });
    });
  });
});

$(function () {
  $(document).ready(function () {
    $(".del_track").click(function (event) {
      var buttonId = $(event.target).attr('data-id');
      $.ajax({
        url: "/favourite_track",
        method: "DELETE",
        data: {track_id: buttonId},
        success: function () {
          location.reload();
        },
        error: function (error) {
          alert('Error! Track has not been deleted');
        }
      });
    });
  });
});

$(function () {
  $(document).ready(function () {
    $(".add_track").click(function (event) {
      var buttonId = $(event.target).attr('data-id');
      $.ajax({
        url: "/favourite_track",
        method: "POST",
        data: {track_id: buttonId},
        success: function () {
          location.reload();
        },
        error: function (error) {
          alert('Error! Track has not been added');
        }
      });
    });
  });
});