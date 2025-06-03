import SwiftUI
import shared

struct MoviesListView: View {
    @StateViewModel var viewModel = SharedViewModelModule.shared.getMoviesNowViewModel()

    var body: some View {
        NavigationView {
            if let loadingState = viewModel.uiState.result as MovieNowStateResult.Loading {
                VStack() {
                    MoviesHeaderView()
                    ProgressView()
                }
            } else if let successState = viewModel.uiState.result as MovieNowStateResult.Success {
                ScrollView {
                    MoviesHeaderView()
                    VStack(spacing: 20) {
                        ForEach(successState.movies) { movie in
                            NavigationLink(destination: MovieDetailsView(movie: movie)) {
                                MovieCard(movie: movie)
                            }
                        }
                    }
                }
            } else if let failedState = viewModel.uiState.result as MovieNowStateResult.Failed {
                FailedMovieListView(
                    errorMsg: failedState.error, 
                    retryAction: { viewModel.loadMovies() }
                )
            }
        }
        .navigationBarHidden(true)
        .background(ColorTheme.secondary)
    }
}


struct MoviesListView_Previews: PreviewProvider {
	static var previews: some View {
		MoviesListView()
	}
}