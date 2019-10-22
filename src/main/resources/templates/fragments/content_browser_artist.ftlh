<div class="container" style="margin-top:30px">
    <div class="container-fluid">
      <table class="table table-borderless">
        <tr>
          <td style="text-align: center"><h2>Artist Search</h2></td>
        </tr>
      </table>
    </div>

    <div class="container">
      <div class="row justify-content-center">
        <div class="col-4 text-right">
          <button type="button" class="btn btn-outline-secondary" id="searchByName">
            Search by name
          </button>
        </div>
        <div class="col-4 mb-5">
          <input type="text" name="searchArtist" id="searchArtist"
                 placeholder="Enter artist's name..." class="form-control"/>
        </div>
      </div>
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
                <th scope="col" style="width: 35%">Genres</th>
                <th scope="col" style="width: 15%">Favourite</th>
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
                            <button id='add_artist' data-id='${artist.id}' class="add_artist"
                                <#if favouriteArtistsIds?seq_contains(artist.id) != false>disabled</#if>>
                                Add
                            </button>
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
                <strong>Type artist's name to see the results</strong>
              </div>
            </#if>
        </table>
    </div>
    <script src="/js/artists.js"></script>
</div>