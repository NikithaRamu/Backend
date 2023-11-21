package com.nikitha.fsd.recommend.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class GifConsumed {
		

		private String gifId;
		private String gifURL;
		private LocalDateTime bookmarkCreatedAt;
		
		
		public GifConsumed()
		{
			
		}
		
		
		public GifConsumed(String gifId, String gifURL, LocalDateTime bookmarkCreatedAt) {
			

			this.gifId = gifId;
			this.gifURL = gifURL;
			this.bookmarkCreatedAt = bookmarkCreatedAt;
		}


		public String getGifId() {
			return gifId;
		}


		public void setGifId(String gifId) {
			this.gifId = gifId;
		}


		public String getGifURL() {
			return gifURL;
		}


		public void setGifURL(String gifURL) {
			this.gifURL = gifURL;
		}




		public LocalDateTime getBookmarkCreatedAt() {
			return bookmarkCreatedAt;
		}


		public void setBookmarkCreatedAt() {
			LocalDateTime bookmarkCreatedAt = LocalDateTime.now();
			this.bookmarkCreatedAt = bookmarkCreatedAt;
		}


		@Override
		public String toString() {
			return "GifRecommended [gifId=" + gifId + ", gifURL=" + gifURL 
					+ ", bookmarkCreatedAt=" + bookmarkCreatedAt + "]";
		}
		
		
		
}
