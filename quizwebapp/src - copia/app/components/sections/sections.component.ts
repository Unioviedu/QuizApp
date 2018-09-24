import { Component, OnInit } from '@angular/core';
import { SectionsService } from '../../services/sections.service'

@Component({
  selector: 'app-sections',
  templateUrl: './sections.component.html',
  styleUrls: ['./sections.component.css']
})
export class SectionsComponent implements OnInit {
  sections:any[];

  constructor(private sectionsService: SectionsService) { }

  ngOnInit() {
    this.loadSections();
  }

  loadSections() {
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.sectionsService.getSectionsList(currentUser.username).subscribe(
      data => {
        this.sections = data;
      }
    );
  }

}
