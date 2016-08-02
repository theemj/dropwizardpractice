require('styles/Note.css');

import React from 'react';
import {NoteForm} from './NoteForm';
const $ = require('jquery');

export class NoteComponent extends React.Component
{

  constructor()
  {
    super();
    this.state = {
      isBeingEdited: false
    }
  }

  render()
  {
    if (this.state.isBeingEdited)
    {
      return (
        <NoteForm onCreate={() => {
          this.props.onDelete();
          this.setState({isBeingEdited:false});
        }}
        id={this.props.note.id}/>
      );
    }
    return (
      <div style={this.props.style} className="note">
        <h3 onClick={() => this.setState({isBeingEdited:true})}>{this.props.note.title}</h3>
        <p>{this.props.note.body}</p>
        <button onClick={() => {
          $.ajax({
            method: 'DELETE',
            contentType: 'application/json',
            url: `/api/note/${this.props.note.id}`,
            success: this.props.onDelete
          });
        }}>Delete</button>

      </div>
    );
  }
}

NoteComponent.defaultProps = {
};

// export default NoteComponent;
