<div class="container" style="margin-top:30px">
    <div class="container-fluid">
      <table class="table table-borderless">
        <tr>
          <td style="text-align: center"><h2>Favourite artists</h2></td>
        </tr>
      </table>
    </div>

    <div class="container">
        <ul class="list-group" id="result"></ul>
        <#if artists?? >
        <table class="table table-sm" style="text-align: center">
          <thead>
              <tr>
                <th scope="col" style="width: 3%">Id</th>
                <th scope="col" style="width: 17%">Name</th>
                <th scope="col" style="width: 15%">Popularity</th>
                <th scope="col" style="width: 15%">Type</th>
                <th scope="col" style="width: 42%">Genres</th>
                <th scope="col" style="width: 8%">Favourite</th>
              </tr>
          </thead>
              <tbody>
                  <#if artists?? >
                      <#list artists?sort_by("popularity")?reverse>
                          <#items as artist>
                            <tr>
                              <td>${artist_index+1}.</td>
                              <td>${artist.name}</td>
                              <td>${artist.popularity}</td>
                              <td>${artist.type}</td>
                              <td>${artist.genres}</td>
                              <td>
                                <div style="text-align:center">
                                  <button id='del_artist' data-id='${artist.id}' class="del_artist"
                                      <#if favouriteArtistsIds?seq_contains(artist.id) == false>disabled</#if>>
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
                  <strong>You haven't got any favourite artists yet. Please add some in Artist's Browser view.</strong>
                </div>
            </table>
        </#if>
    </div>
    <script src="/js/artists.js"></script>
</div>