App = Ember.Application.create({});

App.Author = Ember.Object.extend({});
App.Author = App.Author.reopenClass({

	fromJSON: function(jsonObject) {
		var ret = App.Author.create(jsonObject);
		return ret;
	},

	get: function(id) {
		var ret = App.Author.create();
		$.ajax({
			url: "/data/authors/%@".fmt(id),
			success: function(data) {
				ret.setProperties(App.Author.fromJSON(data.author));
			}
		});
		return ret;
	},

	find: function(filter, getBooks) {
		getBooks = arguments.length < 2 ? false : getBooks;
		var ret = [];
		$.ajax({
			url: "/data/authors",
			data: filter,
			success: function(data) {
				data.authors.forEach(function(author){
					if ( getBooks) {
						author = App.Author.fromJSON(author);
						author.books = App.Book.find({author_id: author.id});
					}
					ret.pushObject(author);
				});
			}
		})
		return ret;
	}
});

App.Book = Ember.Object.extend();
App.Book = App.Book.reopenClass({

	fromJSON: function(jsonObject) {
		var ret = App.Book.create(jsonObject);
		return ret;
	},

	get: function(id) {
		var ret = App.Book.create();
		$.ajax({
			url: "/data/books/%@".fmt(id),
			success: function(data) {
				ret.setProperties(App.Book.fromJSON(data.book));
			}
		});
		return ret;
	},

	find: function(filter) {
		var ret = [];
		$.ajax({
			url: "/data/books",
			data: filter,
			success: function(data) {
				data.books.forEach(function(book){
					ret.pushObject(App.Book.fromJSON(book));
				});
			}
		})
		return ret;
	}
});

App.IndexController = Ember.ObjectController.extend({
	authors: [],

	loadAllData: function() {
		var authors = App.Author.find({}, true);
		this.set('authors', authors);
	}
});

App.IndexRoute = Ember.Route.extend({
	setupController: function(controller) {
		controller.loadAllData();
	}
});