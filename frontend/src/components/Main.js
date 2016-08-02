require('normalize.css/normalize.css');
require('styles/App.css');

import React from 'react';
import {NoteComponent} from './Note';
import {NoteForm} from './NoteForm';

const $ = require('jquery');


class AppComponent extends React.Component {

  constructor() {
    super();
    this.state = {
      //message: 'Unset',
      //title: '',
      //body: '',
      notes: []
    };
  }

  componentDidMount() {
    this.loadNotes();
  }

  render() {
    const noteComponents = this.state.notes.map((note) => (
      <NoteComponent
        onDelete={() => this.loadNotes()}
        key={note.id}
        note={note}
        style={{width: '200px'}}/>
    ));

    return (
      <div className="index">
        {noteComponents}

        <NoteForm onCreate={() => this.loadNotes()}/>

      </div>
    );
  }

  loadNotes() {
    $.ajax({
      method: 'GET',
      url: '/api/note',
      success: (results) => {
        this.setState({notes: results});
      }
    });
  }
}

AppComponent.defaultProps = {
};

export default AppComponent;
