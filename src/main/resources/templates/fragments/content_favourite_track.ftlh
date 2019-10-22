<div class="container" style="margin-top:30px">
    <div class="container-fluid">
      <table class="table table-borderless">
        <tr>
          <td style="text-align: center"><h2>Favourite tracks</h2></td>
        </tr>
      </table>
    </div>

    <div class="container">
        <ul class="list-group" id="result"></ul>
        <#if tracks?? >
            <table class="table table-sm" style="text-align: center">
              <thead>
                  <tr>
                    <th scope="col" style="width: 3%">Id</th>
                    <th scope="col" style="width: 17%">Name</th>
                    <th scope="col" style="width: 10%">Popularity</th>
                    <th scope="col" style="width: 5%">Duration</th>
                    <th scope="col" style="width: 15%">Type</th>
                    <th scope="col" style="width: 42%">Artist names</th>
                    <th scope="col" style="width: 8%">Favourite</th>
                  </tr>
              </thead>
              <tbody>
                  <#if tracks?? >
                      <#list tracks?sort_by("popularity")?reverse>
                          <#items as track>
                            <tr>
                              <td>${track_index+1}.</td>
                              <td>${track.name}</td>
                              <td>${track.popularity}</td>
                              <td>${track.durationMs}</td>
                              <td>${track.type}</td>
                              <td>${track.artistNames}</td>
                              <td>
                                  <div style="text-align:center">
                                    <button id='del_track' data-id='${track.id}' class="del_track"
                                        <#if favouriteTracksIds?seq_contains(track.id) == false>disabled</#if>>
                                      Delete
                                    </button>
                                  </div>
                              </td>
                            </tr>
                          </#items>
                      </#list>
                  </#if>
                </tbody>
                <#elseif errorMessage??>
                  <div class="alert alert-danger" role="alert" style="text-align: center">
                    <strong>${errorMessage}</strong>
                  </div>
                <#else>
                  <div class="alert alert-secondary" role="alert" style="text-align: center">
                    <strong>You haven't got any favourite tracks yet. Please add some in Track's Browser view.</strong>
                  </div>
            </table>
        </#if>
    </div>
    <script src="/js/tracks.js"></script>
</div>