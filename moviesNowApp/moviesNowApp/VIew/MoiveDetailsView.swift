import SwiftUI
import shared

struct MovieDetailView: View {
    let movie: Movie

    var body: some View {
        VStack(spacing: 0) {
            //Esse codigo foi feito com AI, pois ainda não tinha trabalhado com viodeos no iOS antes.
            ZStack(alignment: .bottomTrailing) {
                WebView(urlString: movie.trailerUrl)
                    .frame(height: 200)
            }
            
            HStack(alignment: .top) {
                VStack {
                    //Esse codigo foi feito com AI, pois ainda não tinha trabalhado com AsyncImage antes.
                    AsyncImage(url: movie.posterUrl) { phase in
                        switch phase {
                        case .empty:
                            ProgressView()
                                .frame(width: 120, height: 180)
                        case .success(let image):
                            image
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: 120, height: 180)
                                .cornerRadius(8)
                        case .failure:
                            Image(systemName: "photo.fill")
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: 120, height: 180)
                                .foregroundColor(ColorTheme.secondary)
                        @unknown default:
                            EmptyView()
                        }
                    }
                    Spacer()
                }
                .padding(.leading)

                VStack(alignment: .leading, spacing: 5) {
                    Text(movie.description)
                        .font(.callout)
                        .foregroundColor(ColorTheme.tertiary)
                        .multilineTextAlignment(.leading)
                    
                    Text(String(movie.releaseYear))
                        .font(.subheadline)
                        .foregroundColor(ColorTheme.tertiary)
                    
                    Text("\(String(format: "%.2f", movie.duration)) horas")
                        .font(.subheadline)
                        .foregroundColor(ColorTheme.tertiary)

                    Text("⭐ \(String(format: "%.1f", movie.rating))/10")
                        .font(.headline)
                        .foregroundColor(ColorTheme.tertiary)
                }
                .padding(.horizontal)
                Spacer()
            }
            .padding(.top, 16)
            Spacer()
        }
        .background(ColorTheme.tertiary.edgesIgnoringSafeArea(.all))
        .navigationTitle(movie.title)
        .navigationBarTitleDisplayMode(.inline)
        .toolbarBackground(ColorTheme.primary, for: .navigationBar)
        .toolbarBackground(.visible, for: .navigationBar) 
        .toolbarColorScheme(ColorTheme.tertiary, for: .navigationBar)
    }
}