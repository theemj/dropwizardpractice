require('styles/Note.css');

import React from 'react';
const $ = require('jquery');

export class NoteForm extends React.Component
{

  constructor() {
    super();
    this.state = {
      title: '',
      body: ''
    };
  }

  render()
  {
    return (
      <div>
        <input
          value={this.state.title}
          onChange={(e) => this.setState({title: e.target.value})}
          type="text"
          placeholder="Title"/>
        <br/><br/>
        <input
        value={this.state.body}
        onChange={(e) => this.setState({body: e.target.value})}
         type="text" placeholder="Body"/><br/><br/>
        <button onClick={() => {
          $.ajax({
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
              title: this.state.title,
              body: this.state.body,
              id: this.props.id
            }),
            url: '/api/note',
            success: this.props.onCreate
          });
        }}>Save</button>
      </div>
    );
  }
}

NoteForm.defaultProps = {
};
