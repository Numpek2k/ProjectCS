export class RATING_UTILS {
  static convertIntToStars(rating: number) {
    let output = String();
    output.concat(output,'<i class=\"bi bi-star-fill\"></i>');
    Math.round(rating*2)/2;
    for(let i = 0; i < 5; i++){
      if (rating > 0.5) {
        output = output + `<i class="bi bi-star-fill"></i>`;
        rating -= 1;
      }
      else if(rating == 0.5){
        output = output + `<i class="bi bi-star-half"></i>`;
        rating -= 1;
      }
      else
        output = output + `<i class="bi bi-star"></i>`;
    }
    return output;
  }
}
